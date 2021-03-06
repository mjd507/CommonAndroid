package common.http.common;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * Creted by mjd on 2017/2/12.
 */

public class JsonUtil {

    public static JSONObject getJsonObj(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static boolean getBoolean(JSONObject jsonObject, String key) {
        if (jsonObject == null) return false;
        try {
            return jsonObject.getBoolean(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static <T> List<T> getList(JSONObject jsonObj, String key, Class<T> type) {
        if (jsonObj == null) return null;
        try {
            JSONArray jsonArray = jsonObj.getJSONArray(key);
            Gson gson = new Gson();

            List<T> list = new ArrayList<>();
            JsonArray array = new JsonParser().parse(jsonArray.toString()).getAsJsonArray();
            for (JsonElement elem : array) {
                list.add(new Gson().fromJson(elem, type));
            }
            return list;
//           List<JsonObject> jsonObjectList = gson.fromJson(jsonArray.toString(), new TypeToken<List<JsonObject>>() {
//             }.getType());
//            List<T> list = new ArrayList<>();
//            for (JsonObject obj : jsonObjectList) {
//                list.add(gson.fromJson(obj, type));
//            }
//            return list;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static <T> T getObj(JSONObject jsonObject, String key, Class<T> type) {
        if (jsonObject == null) return null;
        try {
            JSONObject obj = jsonObject.getJSONObject(key);
            Gson gson = new Gson();
            return (T) gson.fromJson(obj.toString(), type);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
