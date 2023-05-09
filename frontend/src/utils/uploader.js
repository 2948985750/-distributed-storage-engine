/** @format */

Map.prototype.getKeys = function () {
    var iter = this.keys();
    let result = [];
    for (const val of iter) {
        result.push(val);
    }
    return result;
};

/**
 * @param {File} file 
 */

const getFileData = (file, map = new Map()) => {
    var maxSize = 1048576; // 一TB对应的兆数
    var size = 0
    file.forEach((file) => {
        file.mb = file.size / 1024 / 1024;
        size += file.mb
        const obj = {
            file_name: file.name,
            file_size: file.size.toString(),
            block_count: 0,
        };

        map.set(obj, []);
        const val = map.get(obj);

        segmentationBuffer(file, (result) => {
            val.push(result);
        });
        obj.block_count = val.length.toString();
    });

    if (size > maxSize) {
        throw new RangeError("超出文件大小的限制了")
    }

    return map;
};

const segmentationBuffer = (blob, fn) => {
    const m8 = 8388608; //八兆对应的字节数
    var nextIndex = 0;
    while (nextIndex <= blob.size) {
        fn(blob.slice(nextIndex, nextIndex + m8));
        nextIndex += m8;
    }
};

const getFileBlob = (entries) => {
    const result = []
    return new Promise((resolve) => {
        entries.forEach((entry, index) => {
            entry.file((data) => {
                if (index === entries.length - 1) {
                    resolve(result)
                }
                result.push(data)
            })
        })
    })
}

const getEntry = (items) => {
    return Array.from(items).map((transItem) => {
        /**
         * 如果由文件描述的项目transItem是文件或者文件夹，则webkitGetAsEntry()
         * 返回FileSystemFileEntry或FileSystemDirectoryEntry表示它。
         * 如果该项不是文件也不是文件夹，则返回null。
         */
        return transItem.webkitGetAsEntry();
    });
};

const getFileEntry = (fileEntry) => {
    return new Promise((resolve) => {
        resolve(fileEntry)
    })
}

// 递归查找文件夹中的文件
const getAllFileEntry = items => {
    const handle = list => {
        const promiseAll = list.map(entry => entry?.isDirectory ? fn(entry) : getFileEntry(entry))
        return Promise.all(promiseAll)
    }
    const fn = fileSystemEntry => {
        const reader = fileSystemEntry.createReader()
        return new Promise(res => {
            reader.readEntries(result => {
                res(handle(result))
            })
        })

    }
    return handle(items)
}

export { getEntry, getAllFileEntry, getFileData, getFileBlob };