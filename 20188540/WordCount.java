import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		// 统计一个文件的字符数，单词数，行数
		Scanner input = new Scanner(System.in);
		System.out.println("please input path:");
		String path = input.next();
		
		int countChar=new MyUtil().CharatersNum(path);
		int countWords=new MyUtil().WordNum(path);
		int countLine=new MyUtil().LineNum(path);
		
		String output="D:\\Git\\output.txt";
		
		String Chars="字符数:"+countChar;
		String Words="单词数:"+countWords;
		String Lines="行数："+countLine;
		String MaxWords=new MyUtil().maxWordNum(path);
		
		System.out.println(Chars);
		System.out.println(Words);
		System.out.println(Lines);
		System.out.println(MaxWords.length());
		
		String context=Chars+Words+Lines+MaxWords;
		
		if(new MyUtil().OutputFile(output, context)) {
			System.out.println("文件輸出成功");
		}else {
			System.out.println("文件輸出失敗");
		}
		input.close();
}
}