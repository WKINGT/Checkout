package net.xgs;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFilter {
    public static String filterNewsContentForTest(String news) {
        Pattern pattern = Pattern.compile("<(p|a|P|(.*?)br(.*?))(.*?)>(.*?)<(/p|/a|/P|(.*?)br(.*?))>");
        Matcher matcher = pattern.matcher(news);
        String res = "";
        while (matcher.find()) {
            String a = matcher.group(0);
            res = res + a;
        }
        res = res.replaceAll("&\\w*\\s*;", "");
        res = res.replaceAll("<p.*?>", "    ");
        res = res.replaceAll("</p.*?>", "\n");
        String content = res.replaceAll("<((?!img).)*?>", "");//"<[^{img}].*?>"
        return content;
    }
    public static void main(String[] args) {
        String str1 = "   <div class=\"article-info\">\n" +
                "        <span class=\"time\" id=\"news-time\" data-val=\"1553663174000\">2019-03-27 13:06</span>\n" +
                "        <span data-role=\"original-link\">来源:<a href=\"http://news.cnr.cn/native/gd/20190327/t20190327_524557384.shtml\" target=\"_blank\">央广网</a></span>\n" +
                "                <span class=\"tag\">\n" +
                "                                                              <a href=\"//search.sohu.com/?keyword=论坛&queryType=outside\" target=\"_blank\" data-spm-data=\"t-1\">论坛</a>\n" +
                "                                                                  <em>/</em><a href=\"//search.sohu.com/?keyword=博鳌亚洲论坛&queryType=outside\" target=\"_blank\" data-spm-data=\"t-2\">博鳌亚洲论坛</a>\n" +
                "                                                                  <em>/</em><a href=\"//search.sohu.com/?keyword=发布会&queryType=outside\" target=\"_blank\" data-spm-data=\"t-3\">发布会</a>\n" +
                "                                      </span>\n" +
                "            </div>\n" +
                "</div>\n" +
                "<article class=\"article\" id=\"mp-editor\">\n" +
                "      <p data-role=\"original-title\" style=\"display:none\">原标题：大咖带你一图解锁博鳌亚洲论坛四大学术报告</p>\n" +
                "            <p>　　3月26日至29日，博鳌亚洲论坛2019年年会在中国海南博鳌隆重举行。年会围绕“共同命运 共同行动 共同发展”主题，共设置66场正式活动，内容丰富、议题广泛。论坛首日，博鳌亚洲论坛2019年年会新闻发布会暨旗舰报告发布会发布了博鳌亚洲论坛四大学术报告：《亚洲经济一体化报告》《新兴经济体报告》《亚洲竞争力报告》和《亚洲金融发展报告》。作为论坛最重要的四大学术报告，重点发布亚洲一体化进展、以 E11为代表的新兴经济体状况、亚洲国家竞争力排名、亚洲基础设施融资现状与前景等。 </p> \n" +
                "<p>作为论坛重磅学术报告，四大报告极具含金量、代表性，那么2019年报告分别是什么？有哪些新观点？央视小编用一图解读的方式，邀请大咖带你一图解锁博鳌亚洲论坛四大学术报告！ </p> \n" +
                "<table> \n" +
                " <tbody> \n" +
                "  <tr> \n" +
                "   <td><p align=\"center\"><img src=\"http://5b0988e595225.cdn.sohucs.com/images/20190327/f1fa9d4e97734b8f9352309cc6e66d86.jpeg\" /></p></td> \n" +
                "  </tr> ";

        System.out.println(filterNewsContentForTest(str1));
    }

}
