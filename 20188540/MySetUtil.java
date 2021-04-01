
public class MySetUtil implements Comparable<MySetUtil>{

	private String key;
	private Integer count;

	public MySetUtil(String key, Integer count) {
		// TODO �Զ����ɵĹ��캯�����
		this.key=key;
		this.count=count;
	}

	@Override
	public int compareTo(MySetUtil o) {
		int cmp = count.intValue() - o.count.intValue();
		return (cmp == 0 ? key.compareTo(o.key) : -cmp);
		// ֻ���������һ�����žͿ��Ծ����������ǽ������� -cmp�������У�cmp��������
		// ��ΪTreeSet�����WorkForMap��compareTo�����������Լ�������
	}

	public void setKey(String s) { // ����ת����Сд
		key = s;
	}

	public String getKey() {
		return key;
	}

	public Integer getCount() {
		return count;
	}



}
