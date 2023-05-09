package com.hyz.constants;

/**
 * @author HGD
 * @date 2022/8/25 1:00
 * 用来创建 Block 的 ES 索引表
 */
public class BlockConstants {
    public static final String BLOCK_CONSTANTS_MAPPING =
            "  \"mappings\": {\n" +
                    "    \"properties\": {\n" +
                    "      \"blockId\": {\n" +
                    "        \"type\": \"keyword\",\n" +
                    "        \"index\": false\n" +
                    "      },\n" +
                    "      \"serverId\": {\n" +
                    "        \"type\": \"text\",\n" +
                    "        \"index\": false\n" +
                    "      },\n" +
                    "      \"fileHash\": {\n" +
                    "        \"type\": \"text\",\n" +
                    "        \"index\": false\n" +
                    "      },\n" +
                    "      \"afterBlockId\": {\n" +
                    "        \"type\": \"text\",\n" +
                    "        \"index\": false\n" +
                    "      },\n" +
                    "      \"starSubscript\": {\n" +
                    "        \"type\": \"long\",\n" +
                    "        \"index\": false\n" +
                    "      },\n" +
                    "      \"endSubscript\": {\n" +
                    "        \"type\": \"long\",\n" +
                    "        \"index\": false\n" +
                    "      },\n" +
                    "      \"backupBlockId\": {\n" +
                    "        \"type\": \"text\",\n" +
                    "        \"index\": false\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }";
}
