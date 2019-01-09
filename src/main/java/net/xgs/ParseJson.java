package net.xgs;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseJson {

    //    public List<Map<String,Object>> getList(JsonListRule jlr, List<JSONObject> jsonObjects) {
//        List<Map<String,Object>> entities = new ArrayList<Map<String,Object>>();
//        for (JSONObject obj:jsonObjects) {
//            Map<String,Object> entity = new HashMap<String,Object>();
//            for(String key :jlr.getList().keySet()){
//                entity.put(key,obj.get(jlr.getList().get(key)));
//            }
//            entity.put("curl",this.getContentUrl(obj,jlr.getContentUrl()));
//            entities.add(entity);
//        }
//        return entities;
//    }
    public List<String> getList(JsonListRule jlr, List<JSONObject> jsonObjects) {
        List<String> list = new ArrayList<String>();
        for (JSONObject obj : jsonObjects) {
            list.add(this.getContentUrl(obj, jlr.getContentUrl()));
        }
        return list;
    }


    private String getContentUrl(JSONObject obj, String p) {
        if (obj == null) return "";
        //http://www.sohu.com/a/210586735_114837
        //http://www.sohu.com/a/${id}_${authorId};

        String regEx = "\\$\\{([a-zA-Z0-9_])+?\\}";
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        String new_p = new String(p);
        Matcher matcher = pattern.matcher(new_p);
        while (matcher.find()) {
            String _id = matcher.group();
            String id = _id.replace("${", "").replace("}", "");
            new_p = new_p.replace(_id, obj.getString(id));
        }
        return new_p;
    }

    public String getNextPage() {
        return null;
    }

    public static void main(String[] args) {
        String new_p = "http://www.sohu.com/a/${id}_${authorId}_${test}";
        String regEx = "\\$\\{([a-zA-Z0-9_]+?)\\}";
//        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        Matcher matcher = Pattern.compile(regEx).matcher(new_p);
//        matcher.find();
//        String s3 = matcher.group();
//        String s3 = matcher.replaceFirst("$1");
        while (matcher.find()) {
            String _id = matcher.group(1);
            String id = _id.replace("${", "").replace("}", "");
        }

//        String ss = Pattern.compile(regEx).matcher(new_p).replaceAll("$1");
        System.out.println(11);
    }

}
