package net.xgs.bitmap;

public class KindsOfHash {
	public static int hash1_BKDRHash(String str) {
	    int seed = 131; // 31 131 1313 13131 131313 etc..
	    int hash = 0;
	    int n = str.length()-1;
	    while (n>=0) {
	        hash = hash * seed + str.charAt(n--);
	    }
	    return (hash & 0x7FFFFFFF);
	}
	public static int hash2_APHash(String str) {
	    int hash = 0;
	    int i;
	    for (i=0; i<str.length(); i++) {
	        if ((i & 1) == 0) {
	            hash ^= ((hash << 7) ^ str.charAt(i) ^ (hash >> 3));
	        } else {
	            hash ^= (~((hash << 11) ^ str.charAt(i) ^ (hash >> 5)));
	        }
	    }
	    return (hash & 0x7FFFFFFF);
	}
	public static int hash3_DJBHash(String str) {
	    int hash = 5381;
	    int n = str.length()-1;
	    while (n>=0){
	        hash += (hash << 5) + str.charAt(n--);
	    }
	    return (hash & 0x7FFFFFFF);
	}


	public static void main(String[] args) {
		String s = "https://wenku.baidu.com/view/ab680210a417866fb84a8eaf.html";
		String s1 = "https://wenku.baidu.com/view/ab680210a417866fb84a8eaf.htmll";
		System.out.println(hash1_BKDRHash(s));
		System.out.println(hash2_APHash(s));
		System.out.println(hash3_DJBHash(s));
		System.out.println(hash1_BKDRHash(s1));
		System.out.println(hash2_APHash(s1));
		System.out.println(hash3_DJBHash(s1));
	}
}
