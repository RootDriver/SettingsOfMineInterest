package mine.utils;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;

public class DataUtils {
	/**
	 * This method is to copy data
	 */
	public static <T> void copy(List<? super T> dest, List<? extends T> src) {
		int srcSize = src.size();
		if (srcSize > dest.size())
			throw new IndexOutOfBoundsException("Source does not fit in dest");

		if (srcSize < 10 || (src instanceof RandomAccess && dest instanceof RandomAccess)) {
			for (int i = 0; i < srcSize; i++)
				dest.set(i, src.get(i));
		} else {
			ListIterator<? super T> di = dest.listIterator();
			ListIterator<? extends T> si = src.listIterator();
			for (int i = 0; i < srcSize; i++) {
				di.next();
				di.set(si.next());
			}
		}
	}

	/**
	 * This method is to return a clone for the only parameter
	 * 
	 * @return
	 */
	public static <K, V> Map<K, V> cloneMap(Map<K, V> map) {
		try {
			Map<K, V> newInstance = map.getClass().newInstance();
			if (!map.isEmpty()) {
				newInstance.putAll(map);
			}
			return newInstance;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

}
