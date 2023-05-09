import uploadFile from "../../views/boundBox/uploadFile.vue"
import downloadFile from "../../views/boundBox/downloadFile.vue"

export default function(){
    const BoundTags = {
        uploadFile: uploadFile,
        downloadFile: downloadFile,
    };
    return {
        BoundTags
    }
}
