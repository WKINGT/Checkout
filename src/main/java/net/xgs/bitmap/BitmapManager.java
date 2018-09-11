package net.xgs.bitmap;

import com.googlecode.javaewah32.EWAHCompressedBitmap32;

import java.io.Serializable;


public class BitmapManager implements Serializable{

	private static BitmapManager instance = null;
	private  EWAHCompressedBitmap32 bitmap = new EWAHCompressedBitmap32();
	private BitmapManager() {}
	/**
	 * 获得BitmapManager的实例
	 * @return
	 */
	public static BitmapManager getInstance() {
		if(instance==null){
			instance = new BitmapManager();
		}
		return instance;
	}
	/**
	 * 将url地址加入到bitmap中
	 * @param s
	 */
	public void putString(String s) {
		this.bitmap.set(KindsOfHash.hash1_BKDRHash(s));
		this.bitmap.set(KindsOfHash.hash2_APHash(s));
		this.bitmap.set(KindsOfHash.hash3_DJBHash(s));
	}
	/**
	 * 判断bitmap中是否已经包含该String
	 * @param s
	 * @return
	 */
	public boolean isCotainsString(String s) {
		int hashcode1 = KindsOfHash.hash1_BKDRHash(s);
		int hashcode2 = KindsOfHash.hash2_APHash(s);
		int hashcode3 = KindsOfHash.hash3_DJBHash(s);
		return this.bitmap.get(hashcode1)||this.bitmap.get(hashcode2)||this.bitmap.get(hashcode3);
	}
	public static void main(String[] args) {
		String s = "https://wenku.baidu.com/view/ab680210a417866fb84a8eaf.html";
		String s1 = "https://wenku.baidu.com/view/ab680210a417866fb84a8eaf.htmll";
		BitmapManager.getInstance().putString(s);
		System.out.println(BitmapManager.getInstance().isCotainsString(s));
		System.out.println(BitmapManager.getInstance().isCotainsString(s1));
//		BitmapManager.getInstance().bitmap.clear();
//		System.out.println(BitmapManager.getInstance().isCotainsString(s));
//		System.out.println(BitmapManager.getInstance().isCotainsString(s1));
	}

}
