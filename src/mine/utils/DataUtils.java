package mine.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;

public class DataUtils {
	/**
	 * This method is to copy data with type Collection
	 */
	public static <T> void copy(Collection<? super T> dest, Collection<? extends T> src) {
		int srcSize = src.size();
		if (srcSize > dest.size())
			throw new IndexOutOfBoundsException("Source does not fit in dest");

		if (srcSize < 10 || (src instanceof RandomAccess && dest instanceof RandomAccess)) {
			//I mean, if the collection (src,dest),could be visit by index faster than address,
			//or,it is  ,em...(something like set),small size ,could use this
			Object[] array = src.toArray();
			for(int i = 0 ; i < srcSize ; i++){
				dest.add((T)array[i]);
			}
		} else {
			dest.addAll(src);
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
