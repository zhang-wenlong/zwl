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

	// 返回字符个数
	public int CharatersNum(String file_path) {
//		int countChar = 0;
//		InputStreamReader isr=null;
//		try {
//			if(file_path!=null) {
//				// 将字符流转换为字节流，来读取文件
//				isr = new InputStreamReader(new FileInputStream(file_path));
//				// 缓冲区
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
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally {
//			try {
//				isr.close();
//			} catch (IOException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//		}
//		return countChar;

		int countChar = 0, bytes = 0;

		byte[] item = new byte[20 * 1024];// 定义一个定长数组

		int length = item.length;// 得到item的长度

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file_path);

			while ((bytes = fis.read(item, 0, length)) != -1) {
				countChar += bytes;
			}

		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

		return countChar;
	}

	// 返回单词个数
	public int WordNum(String file_path) {
//		int countWords=0;
//		
//		try {
//			// 将字符流转换为字节流，来读取文件
//			InputStreamReader isr = new InputStreamReader(new FileInputStream(file_path));
//			// 缓冲区
//			BufferedReader br = new BufferedReader(isr);
//
//			while (br.read() != -1) {
//				String s = br.readLine();
//				countWords += s.split(" ").length;//split() 方法用于把一个字符串分割成字符串数组,字符串数组的长度，就是单词个数
//			}
//			isr.close();
//
//		} catch (FileNotFoundException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
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
			fis = new FileInputStream(file_path);// 文件字符输入流
			isr = new InputStreamReader(fis);// 文件字节输入流
			br = new BufferedReader(isr);// 文件缓存输入流

			while (br.read() != -1) {
				temp = br.readLine();
				sb.append(temp);// 将读出来的数据保存在temp中
				sb.append(" ");// 添加一个空格
			}
			// 用字符串存储，方便split方法分开
			temp = sb.toString();
			// 所有非字母的数字符号全部替换成空格
			temp = temp.replaceAll("[^A-Za-z0-9]", " ");
			// 将temp中的字母全部变为小写
			temp = temp.toLowerCase();

			String[] total = temp.split(" ");// 将temp中的单词用“ ”分开
			countWords = total.length;
			
			for (int i = 0; i < total.length; i++) {
				String s = total[i].toString();
				if (s.length() < 4) {// 如果字符小于4个
					countWords--;
				} else {
					for (int j = 0; j < 4; j++) {// 如果字符数大于4但是前面为数字
						char c = s.charAt(j);
						if (!(c >= 'a' && c <= 'z')) {
							countWords--;
							break;
						}
					}
				}
			}

		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				isr.close();// 关闭字节输入流
				br.close();// 关闭缓存输入流
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} // 关闭文件字符输入流

		}
		return countWords;
	}

	// 返回行数
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				isr.close();
				br.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return countLine;
	}

	// 返回单词的出现次数
	public String maxWordNum(String file_path) {
		String result = "";
		String temp = "";
		StringBuffer sb = new StringBuffer();
		FileInputStream fis = null;// 字符输入流
		InputStreamReader isr = null;// 字节输入流
		BufferedReader br = null;// 缓存输入流

		try {
			fis = new FileInputStream(file_path);
			isr = new InputStreamReader(fis);// 文件字节输入流
			br = new BufferedReader(isr);// 文件缓存输入流

			while (br.read() != -1) {
				temp = br.readLine();
				sb.append(temp);// 将读出来的数据保存在temp中
				sb.append(" ");// 添加一个空格
			}
			Map<String, Integer> map = new HashMap<String, Integer>();// 运用哈希排序
			temp = sb.toString();

			temp = temp.replaceAll("[^A-Za-z0-9]", " ");

			temp = temp.toLowerCase();

			StringTokenizer st = new StringTokenizer(temp, " ");// 分割字符串

			while (st.hasMoreTokens()) {
				String letter = st.nextToken();// 把分割好的字符串保存到letter中
				int count;
				if (map.get(letter) == null) {
					count = 1;// 表示没有分割
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
						if (!(c >= 'a' && c <= 'z'))// 只要是字母都已经换成小写了
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} // 文件字符输入流
		catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				isr.close();
				br.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return result;
	}
	//输出到文件
	public boolean OutputFile(String File_path,String Context){
		
		File OutputFile = new File(File_path); //创建File对象
		FileOutputStream os = null; //声明 文件输出流
		
		byte [] a = null; //用于存储Context转化的byte字节数组
		
		try {
			if(!OutputFile.exists()) {        //判断文件是否存在
				OutputFile.createNewFile(); //不存在，创建一个文件
			}
			FileWriter fw =new FileWriter(File_path);//设置清空文件内容功能
			
			fw.write("");
			fw.flush();
			fw.close();
		    
			os = new FileOutputStream(OutputFile); //获得输出流对象
			a = Context.getBytes(); //将Context转化为Byte数组，以便写入文件
			os.write(a); //将byte数组写入文件
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			try {
				os.close(); //关闭输出流
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
}
