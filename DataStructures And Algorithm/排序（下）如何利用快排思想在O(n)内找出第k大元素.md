# 排序（下）如何利用快排思想在O(n)内找出第k大元素

有两种方法比较适合大规模数据的排序，**归并排序和快速排序**，时间复杂度为O(nlogn)。



### 归并排序

#### 归并排序的原理

* 归并排序的核心思想是把数组分成两部分，然后分别排序，排好序后再合并在一起。

<img src="https://static001.geekbang.org/resource/image/db/2b/db7f892d3355ef74da9cd64aa926dc2b.jpg" alt="img" style="zoom:60%;" />

* 归并排序的思路来源于**分治思想**，就是将大问题分解成小问题，把小问题全部解决大问题就解决了。这和递归思路很近。**而分治算法一般都是通过递归来实现的**。

#### 归并排序的实现代码

```java
package com.pcq.sort;

import com.pcq.util.ArrayUtil;

/**
 * 归并排序
 * @author pcq
 *
 */
public class MergeSort {

	
	public static void main(String[] args) {
		int[] a = ArrayUtil.getArray(8);
		ArrayUtil.printArray(a);
		mergeSort(a, 0, a.length - 1);
		ArrayUtil.printArray(a);
	}
		
	public static void mergeSort(int[] array, int start, int end) {
		if(start < end) {//递归终止条件,当start和end相等时，也就是只有一个元素，就是终止条件
			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}
	
	
	/**
	 * 
	 * @param array
	 * @param left
	 * @param mid
	 * @param right
	 */
	public static void merge(int[] array,int left, int mid, int right)  {
		int[] temp = new int[array.length];//临时数组
		int k = left;//存放指针
		int p = left;
		int q = mid + 1;
		while(p <= mid && q <= right) {
			if(array[p] <= array[q]) {
				temp[k++] = array[p++];
			} else {
				temp[k++] = array[q++];
			}
		}
		//看哪个子数组没有放完，则补充到临时数组之中
		while(p <= mid)
			temp[k++] = array[p++];
		while(q <= right)
			temp[k++] = array[q++];
		for(int i = left; i <= right; i++) {
			array[i] = temp[i];
		}
	}
	
}

```

#### 归并排序的性能分析

* 归并排序是稳定的排序算法吗？

  * 在merge函数中当两个子数组元素相等时，永远先把左边的子数组元素放入合并的数组中，就保证了这种稳定性。

* 归并排序的时间复杂度是多少？

  * 由于归并排序使用到了递归，因此这里需要分析一下递归的时间复杂度分析。

  ---

  问题a被分解成子问题b和子问题c，那么求解问题a的时间是：

  ```
  T(a) = T(b) + T(c) + k
  ```

  其中k是将b、c合并成a花费的时间。

  ---

  * 对n个元素进行归并排序的时间是T(n),那么分解成2个子数组它们各自的排序时间就是T(n/2)。merge函数的时间复杂度是O(n)，因此归并排序的时间复杂度就是：

  ```
  T(1) = C; //n=1
  T(n) = 2 * T(n/2) + n  //n>1
  ```

  * 如果将公式继续分解则：

$$
T(n)=2*T(\frac{n}{2}) + n
$$
$$
=2*(2*T(\frac{n}{4})+\frac{n}{2})+n=4*T(\frac{n}{4})+2n
$$
$$
=4*(2*T(\frac{n}{8}) + \frac{n}{4}) + 2n=8*T(\frac{n}{8})+3n
$$
$$
...
=2^k*T(\frac{n}{2^k})+kn
$$
​			当T(n/2^k) = T(1)时，即n/2^k = 1,解得
$$
  k=log_2n
$$
​			将k带入上述公式，则
$$
T(n)=Cn+nlog_2n
$$
  		   大O表示法归并排序的时间复杂度就是
$$
O(nlog_2n)
$$

<font color='red'>**归并排序的时间复杂度和原始数据的有序度无关,不管是最好最坏还是平均时间复杂度都是一样的，所以很稳定。**</font>

* 归并排序的空间复杂度是多少？

由于每次都需要一个额外的临时数组，因此归并排序的空间复杂度是O(n)，这也是归并排序的最大弱点，它并不是原地排序算法。



快速排序


快速排序的原理

#### 快速排序的性能分析

