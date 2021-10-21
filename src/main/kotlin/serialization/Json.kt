package serialization

import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject

fun JsonObject.append(vararg jsonObjects: JsonObject): JsonObject {
    return buildJsonObject {
        onEach { (key, jsonElement) ->
            put(key, jsonElement)
        }

        jsonObjects.forEach { jsonObject ->
            jsonObject.onEach { (key, jsonElement) ->
                put(key, jsonElement)
            }
        }
    }
}