
public class MySetUtil implements Comparable<MySetUtil>{

	private String key;
	private Integer count;

	public MySetUtil(String key, Integer count) {
		// TODO 自动生成的构造函数存根
		this.key=key;
		this.count=count;
	}

	@Override
	public int compareTo(MySetUtil o) {
		int cmp = count.intValue() - o.count.intValue();
		return (cmp == 0 ? key.compareTo(o.key) : -cmp);
		// 只需在这儿加一个负号就可以决定是升序还是降序排列 -cmp降序排列，cmp升序排列
		// 因为TreeSet会调用WorkForMap的compareTo方法来决定自己的排序
	}

	public void setKey(String s) { // 用来转换大小写
		key = s;
	}

	public String getKey() {
		return key;
	}

	public Integer getCount() {
		return count;
	}



}
