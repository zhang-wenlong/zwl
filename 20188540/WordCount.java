import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		// ͳ��һ���ļ����ַ�����������������
		Scanner input = new Scanner(System.in);
		System.out.println("please input path:");
		String path = input.next();
		
		int countChar=new MyUtil().CharatersNum(path);
		int countWords=new MyUtil().WordNum(path);
		int countLine=new MyUtil().LineNum(path);
		
		String output="D:\\Git\\output.txt";
		
		String Chars="�ַ���:"+countChar;
		String Words="������:"+countWords;
		String Lines="������"+countLine;
		String MaxWords=new MyUtil().maxWordNum(path);
		
		System.out.println(Chars);
		System.out.println(Words);
		System.out.println(Lines);
		System.out.println(MaxWords.length());
		
		String context=Chars+Words+Lines+MaxWords;
		
		if(new MyUtil().OutputFile(output, context)) {
			System.out.println("�ļ�ݔ���ɹ�");
		}else {
			System.out.println("�ļ�ݔ��ʧ��");
		}
		input.close();
}
}