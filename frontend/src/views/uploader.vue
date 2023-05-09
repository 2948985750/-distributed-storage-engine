<!-- @format -->
<script setup>
import {
	ref,
	computed,
	watchEffect,
	nextTick,
	reactive,
	watch,
	onMounted,
	h,
} from "vue";
import { debounce, cloneDeep, flattenDeep } from "lodash";
import { notification } from "ant-design-vue";
import { LoadingOutlined, CheckOutlined } from '@ant-design/icons-vue';
import {
	getEntry,
	getAllFileEntry,
	getFileBlob,
	getFileData,
} from "../utils/uploader";

const fileInfoVisible = ref(false);
const warnVisible = ref(false);
const inputRef = ref();

const btnSize = ref("large");
const fileListVisble = ref(false);
const isFinish = ref(false)

const mapKeys = ref([]);
const mapList = ref()

watchEffect(() => {
	window.asd = mapKeys.value;
	window.qwe = mapList.value;
})

const deb = debounce(() => {
	alert("你上传的不是文件或文件夹");
}, 50);

const notify = debounce(() => {
	notification.open({
		message: "操作指引",
		description: "可以通过拖动、点击“上传文件按钮”或者复制粘贴文件夹、文件",
		onClick: () => {
			console.log("Notification Clicked!");
		},
		duration: 2,
		maxCount: 1,
	});
}, 1000, {
	'leading': false,
});

onMounted(() => {
	fileWranVisible();
});

watchEffect(() => {

})

const fileWranVisible = () => {
	warnVisible.value = true;
};

/**
* 以下均为事件处理函数
*/
const fileListModalHandle = () => {
	var proAll;
	const arr = [...mapKeys.value];

	proAll = arr.map(iter => {
		let sendData = {
			file_name: iter.file_name,
			file_size: iter.file_size,
			block_count: iter.block_count
		}
		return new Promise((resolve) => {
			fetch('/file/upload/metadata', {
				method: "post",
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(sendData)
			}).then(data => {
				resolve(data)
				var blobs = mapList.value.get(iter);
				var subprocess = blobs.map((blob, index) => {
					// 构建一个 formData 对象
					let formData = new FormData();
					formData.append("data", blob);
					formData.append("order", index);

					return new Promise((resolve) => {
						fetch('/file/upload/data', {
							method: "post",
							headers: {
								// "Content-Type": "multipart/form-data"
								// 不要自己设置 Content-Type，因为浏览器自己会根据 body 推断
								// 如果自己设置了 Content-Type 为 form-data，那还要设置一个 boundary 分隔符
								// 不然，后端就会报 no multipart boundary param in Content-Type 错误
								"Connection": "keep-alive",
								"Keep-Alive": "timeout=5"
							},
							body: formData
						}).then(() => {
							resolve()
						})
					})
				})

				Promise.all(subprocess).then(() => {
					iter.isUploadSuccess = true;
				})
			})
		})
	})

	return Promise.all(proAll);
};

const onDrag = (e) => {
	// console.log(e.dataTransfer);
};

const onDragover = (e) => {
	e.preventDefault();
};

const onPaste = (e) => {
	const items = e.dataTransfer.items;
	clipboardDataItems.value = items;
};

const upload = () => {
	inputRef.value.click();
};

const onDrop = (e) => {
	fileInfoVisible.value = true
	e.preventDefault();
	const items = e.dataTransfer.items;
	const entry = getEntry(items);
	console.log(entry);

	getAllFileEntry(entry).then(entries => {
		console.log(entries);
		const result = flattenDeep(entries)
		return result;
	}).then(fileEntry => {
		return getFileBlob(fileEntry)
	}).then(files => {
		return getFileData(files)
	}).catch((err) => {
		alert('line 157' + err)
	}).then(map => {
		console.log(map)
		mapKeys.value = [...map.keys()];
		mapList.value = map;
	})
};

const onFileChange = (e) => {
	files.value = e.target.files;
};

const onOk = () => {
	warnVisible.value = false;
	notify();
}

const onDelete = (index) => {
	// console.log(index);
	mapKeys.value.splice(index, 1)
}

const sendFile = () => {
	isFinish.value = true;
	fileListModalHandle().then(() => {
		alert('全部上传成功')
	})
}

</script>

<template>
	<div id="uploader" @dragover="onDragover" @drop="onDrop" @paste="onPaste" @drag="onDrag">
		<a-modal v-model:visible="warnVisible" title="警告信息" @ok="onOk" :centered="true">
			<template #cancelText></template>
			<template #okText>确定</template>
			不要上传违法违规文件,
			诸如暴力、赌博、色情等
		</a-modal>
		<a-modal v-model:visible="fileInfoVisible" :centered="true"
			:bodyStyle="{ height: '400px', overflowY: 'scroll' }" :closable="false" @ok="sendFile">
			<template #cancelText>取消</template>
			<template #okText>确定</template>
			<a-list item-layout="horizontal" :data-source="mapKeys">
				<template #renderItem="{ item, index }">
					<a-list-item @click="onDelete(index)">
						<template #actions>
							删除
						</template>
						<a-list-item-meta>
							<template #title>
								<span>{{ item.file_name }}</span>
								<span style="margin-left: 20px;">{{ Math.floor(item.file_size / 1024 / 1024) + 'mb'
								}}</span>
							</template>
							<template v-if="isFinish" #avatar>
								<CheckOutlined v-if="item.isUploadSuccess"></CheckOutlined>
								<LoadingOutlined v-else></LoadingOutlined>
							</template>
						</a-list-item-meta>
					</a-list-item>
				</template>
			</a-list>
		</a-modal>
		<a-row justify="center">
			<img src="../assets/bg.png" alt="" draggable="false" />
			<!-- -webkit-user-drag:none -->
		</a-row>
		<a-row justify="center">
			<a-button type="primary" @click="upload" :size="btnSize">
				上传文件
			</a-button>
		</a-row>
		<a-row justify="center">
			<a-button :size="btnSize">接收文件</a-button>
		</a-row>
		<a-row justify="center">
			<input id="file" type="file" multiple="file" ref="inputRef" @change="onFileChange" />
		</a-row>
	</div>
</template>


<style lang="less" scoped>
.ant-modal .ant-modal-content .ant-modal-body {
	padding: 0;
}

#uploader {
	display: flex;
	flex-flow: column nowrap;
	align-content: center;
	justify-content: center;
	width: 100vw;
	height: 100vh;
	position: relative;

	#file {
		display: none;
	}
}
</style>