package javaassignment2;

import java.io.File;
import java.io.FilenameFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Tester {

	private static Object a;
	private static Object c;

	private static Tester a() {

		return null;
	}

	private static Tester b() {

		return null;
	}

	private static Tester c() {
		int a;

		return null;
	}
	
	


	public static void main(String[] args) {

		a().b().c = c().b().a;

		File dir = new File("C:\\");

		File[] files = dir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File directory, String fileName) {
				if (fileName.endsWith("")) {
					return true;
				}
				return false;
			}
		});

		Map<Date, List<File>> mapFiles = new TreeMap<>();

		SimpleDateFormat sdf = new SimpleDateFormat("MM");

		for (File file : files) {
			try {
				Date date = sdf.parse(sdf.format(new Date(file.lastModified())));
				List<File> group = mapFiles.get(date);
				if (group == null) {
					group = new ArrayList<>();
					mapFiles.put(date, group);
				}
				group.add(file);
			} catch (ParseException ex) {
				ex.printStackTrace();
			}
		}

		for (Date date : mapFiles.keySet()) {
			System.out.println(sdf.format(date));

			List<String> fileNames = new ArrayList<>();

			for (File file : mapFiles.get(date)) {

				fileNames.add(file.toString());

//				System.out.println("    " + file);

			}
			System.out.println("    " + fileNames.size());
		}
	}

}
