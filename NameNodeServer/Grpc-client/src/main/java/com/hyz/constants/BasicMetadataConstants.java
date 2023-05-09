package com.hyz.constants;

/**
 * @author HGD
 * @date 2022/8/25 0:32
 * 用来创建 BasicMetadata 的 ES 索引表
 */
public class BasicMetadataConstants {
    public static final String BASIC_METADATA_MAPPING =
            "  \"mappings\": {\n" +
                    "    \"properties\": {\n" +
                    "      \"fileName\":{\n" +
                    "        \"type\": \"text\",\n" +
                    "        \"copy_to\": \"search\"\n" +
                    "      },\n" +
                    "      \"fileSize\":{\n" +
                    "        \"type\": \"text\"\n" +
                    "      },\n" +
                    "      \"fileExtension\":{\n" +
                    "        \"type\": \"text\",\n" +
                    "        \"copy_to\": \"search\"\n" +
                    "      },\n" +
                    "      \"path\":{\n" +
                    "        \"type\": \"keyword\",\n" +
                    "        \"copy_to\": \"search\",\n" +
                    "        \"index\": false\n" +
                    "      },\n" +
                    "      \"fileHash\":{\n" +
                    "        \"type\": \"keyword\",\n" +
                    "        \"index\": false\n" +
                    "      },\n" +
                    "      \"data\":{\n" +
                    "        \"type\": \"date\",\n" +
                    "        \"copy_to\": \"search\"\n" +
                    "      },\n" +
                    "      \"search\":{\n" +
                    "        \"type\": \"text\",\n" +
                    "        \"analyzer\": \"ik_max_word\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }";
}
