Bitmap:
定义：Bit-Map算法又名位图算法,就是用一个数作为下标（index）来索引一个bit位表示一个数是否存在。
用途：解决海量数据进行快速查找，判重，删除.
优点：由于采用了Bit为单位来存储数据，因此在存储空间方面，可以大大节省。
40亿个int数占（40亿*4）/1024/1024/1024 大概为14.9G。
用一个bit位来标识一个int整数那么存储空间将大大减少，40亿个int需要的内存空间为40亿/8/1024/1024大概为476.83 mb.
https://www.jianshu.com/p/6082a2f7df8e

EWAHCompressedBitmap  和 BitSet


<dependency>
  <groupId>com.googlecode.javaewah</groupId>
  <artifactId>JavaEWAH</artifactId>
  <version>1.1.0</version>
</dependency>

使用Bitmap的思想，可以将存储空间进行压缩，而且可以对数字进行快速排序、去重和查询的操作。
扩展
Bloom filter 一种多哈希函数映射的快速查找算法.
Bloom Filter是Bitmap思想的一种扩展，它可以在允许低错误率的场景下，大大地进行空间压缩，是一种拿错误率换取空间的数据结构。
优点是查询效率高、可节省空间。
缺点是会存在一定的错误。因此Bloom filter 算法仅仅能应用于那些同意有一定错误的场合，如爬虫URL去重。

http://5b0988e595225.cdn.sohucs.com/images/20180111/39af275caa0544e7be89e32f58252fa4.jpeg