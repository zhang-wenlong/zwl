import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MyUtil {

	// �����ַ�����
	public int CharatersNum(String file_path) {
//		int countChar = 0;
//		InputStreamReader isr=null;
//		try {
//			if(file_path!=null) {
//				// ���ַ���ת��Ϊ�ֽ���������ȡ�ļ�
//				isr = new InputStreamReader(new FileInputStream(file_path));
//				// ������
//				BufferedReader br = new BufferedReader(isr);
//
//				while (br.read() != -1) {
//					
//					String s = br.readLine();
//					
//					countChar += s.length();
//					
//					
//				}
//			}
//		} catch (FileNotFoundException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally {
//			try {
//				isr.close();
//			} catch (IOException e) {
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
//		}
//		return countChar;

		int countChar = 0, bytes = 0;

		byte[] item = new byte[20 * 1024];// ����һ����������

		int length = item.length;// �õ�item�ĳ���

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file_path);

			while ((bytes = fis.read(item, 0, length)) != -1) {
				countChar += bytes;
			}

		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}

		return countChar;
	}

	// ���ص��ʸ���
	public int WordNum(String file_path) {
//		int countWords=0;
//		
//		try {
//			// ���ַ���ת��Ϊ�ֽ���������ȡ�ļ�
//			InputStreamReader isr = new InputStreamReader(new FileInputStream(file_path));
//			// ������
//			BufferedReader br = new BufferedReader(isr);
//
//			while (br.read() != -1) {
//				String s = br.readLine();
//				countWords += s.split(" ").length;//split() �������ڰ�һ���ַ����ָ���ַ�������,�ַ�������ĳ��ȣ����ǵ��ʸ���
//			}
//			isr.close();
//
//		} catch (FileNotFoundException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}
//		
//		return countWords;

		int countWords = 0;
		// String result="";
		String temp = "";
		StringBuffer sb = new StringBuffer();
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(file_path);// �ļ��ַ�������
			isr = new InputStreamReader(fis);// �ļ��ֽ�������
			br = new BufferedReader(isr);// �ļ�����������

			while (br.read() != -1) {
				temp = br.readLine();
				sb.append(temp);// �������������ݱ�����temp��
				sb.append(" ");// ���һ���ո�
			}
			// ���ַ����洢������split�����ֿ�
			temp = sb.toString();
			// ���з���ĸ�����ַ���ȫ���滻�ɿո�
			temp = temp.replaceAll("[^A-Za-z0-9]", " ");
			// ��temp�е���ĸȫ����ΪСд
			temp = temp.toLowerCase();

			String[] total = temp.split(" ");// ��temp�еĵ����á� ���ֿ�
			countWords = total.length;
			
			for (int i = 0; i < total.length; i++) {
				String s = total[i].toString();
				if (s.length() < 4) {// ����ַ�С��4��
					countWords--;
				} else {
					for (int j = 0; j < 4; j++) {// ����ַ�������4����ǰ��Ϊ����
						char c = s.charAt(j);
						if (!(c >= 'a' && c <= 'z')) {
							countWords--;
							break;
						}
					}
				}
			}

		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				isr.close();// �ر��ֽ�������
				br.close();// �رջ���������
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} // �ر��ļ��ַ�������

		}
		return countWords;
	}

	// ��������
	public int LineNum(String file_path) {
		int countLine = 0;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			fis = new FileInputStream(file_path);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);

			while (br.readLine() != null) {
				countLine++;
			}

		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				isr.close();
				br.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		return countLine;
	}

	// ���ص��ʵĳ��ִ���
	public String maxWordNum(String file_path) {
		String result = "";
		String temp = "";
		StringBuffer sb = new StringBuffer();
		FileInputStream fis = null;// �ַ�������
		InputStreamReader isr = null;// �ֽ�������
		BufferedReader br = null;// ����������

		try {
			fis = new FileInputStream(file_path);
			isr = new InputStreamReader(fis);// �ļ��ֽ�������
			br = new BufferedReader(isr);// �ļ�����������

			while (br.read() != -1) {
				temp = br.readLine();
				sb.append(temp);// �������������ݱ�����temp��
				sb.append(" ");// ���һ���ո�
			}
			Map<String, Integer> map = new HashMap<String, Integer>();// ���ù�ϣ����
			temp = sb.toString();

			temp = temp.replaceAll("[^A-Za-z0-9]", " ");

			temp = temp.toLowerCase();

			StringTokenizer st = new StringTokenizer(temp, " ");// �ָ��ַ���

			while (st.hasMoreTokens()) {
				String letter = st.nextToken();// �ѷָ�õ��ַ������浽letter��
				int count;
				if (map.get(letter) == null) {
					count = 1;// ��ʾû�зָ�
				} else {
					count = map.get(letter).intValue() + 1;

				}
				map.put(letter, count);
			}
			Set<MySetUtil> set = new TreeSet<MySetUtil>();
			for (String key : map.keySet()) {
				set.add(new MySetUtil(key, map.get(key)));
			}
			int count = 1;
			for (Iterator<MySetUtil> it = set.iterator(); it.hasNext();) {
				MySetUtil msu = it.next();
				boolean isWords = true;
				if (msu.getKey().length() > 4) {
					String s = msu.getKey();
					for (int i = 0; i < 4; i++) {
						char c = s.charAt(i);
						if (!(c >= 'a' && c <= 'z'))// ֻҪ����ĸ���Ѿ�����Сд��
						{
							isWords = false;
							break;
						}
						if (isWords == true) {
							result += msu.getKey() + ": " + msu.getCount() + "\n";
							if (count == 10) {
								break;
							}
							count++;
						}
					}

				}
			}
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} // �ļ��ַ�������
		catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				isr.close();
				br.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		return result;
	}
	//������ļ�
	public boolean OutputFile(String File_path,String Context){
		
		File OutputFile = new File(File_path); //����File����
		FileOutputStream os = null; //���� �ļ������
		
		byte [] a = null; //���ڴ洢Contextת����byte�ֽ�����
		
		try {
			if(!OutputFile.exists()) {        //�ж��ļ��Ƿ����
				OutputFile.createNewFile(); //�����ڣ�����һ���ļ�
			}
			FileWriter fw =new FileWriter(File_path);//��������ļ����ݹ���
			
			fw.write("");
			fw.flush();
			fw.close();
		    
			os = new FileOutputStream(OutputFile); //������������
			a = Context.getBytes(); //��Contextת��ΪByte���飬�Ա�д���ļ�
			os.write(a); //��byte����д���ļ�
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			try {
				os.close(); //�ر������
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
}
