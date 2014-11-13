import java.nio.channels.ScatteringByteChannel;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class LRUCache {

	private static class Item {
		int key;
	    int value;
		Item pre;
		Item next;
	}

	private static Map<Integer,Item> sCache = new HashMap<Integer, LRUCache.Item>();
	private Item mHead = new Item();
	private Item mTail = new Item();
	private int mCapacity;

	public LRUCache(int capacity) {
		mCapacity = capacity;
		initHeadAndTailPtr();
	}

	private void initHeadAndTailPtr() {
		mHead.pre = null;
		mHead.next = mTail;
		mTail.pre = mHead;
		mTail.next = null;
	}

	public int get(int key) {
		Item ret = sCache.get(key);
		if(ret == null) {
			return -1;
		}
		moveItemToHead(ret);
		System.out.println(ret.value);
		return ret.value;
	}

	public void set(int key,int value) {
		if(value < 0 || mCapacity <= 0) {
			return;
		}

		if(sCache.size() == mCapacity) {
			removeItemAtTail();
		}
		Item item = new Item();
		item.key = key;
		item.value = value;
		sCache.put(key, item);
		moveItemToHead(item);
	}

	private void moveItemToHead(Item item) {
		if(item.pre != null && item.next != null) {
			item.pre.next = item.next;
			item.next.pre = item.pre;
			item.pre = null;
			item.next = null;
		}
		item.next = mHead.next;
		item.pre = mHead;
		mHead.next = item;
	    item.next.pre = item;

	}

	private void removeItemAtTail() {
		Item tailItem = mTail.pre;
		if (tailItem != null && tailItem.pre != null) {
			tailItem.pre.next = mTail;
			tailItem.next.pre = tailItem.pre;
			sCache.remove(tailItem.key);
			tailItem = null;
		}

	}

	private void displayList() {
		Item curItem = mHead;
		while(curItem != null) {
			System.out.println("key : " + curItem.key + " value : " +curItem.value);
			curItem = curItem.next;
		}
	}

//	public static void main(String[] args) {
//		LRUCache lruCache = new LRUCache(2);
//	 	lruCache.set(2, 1);
//	 	lruCache.set(1, 1);
//	 	lruCache.get(2);
//	 	lruCache.set(4,1);
//	 	lruCache.get(1);
//		lruCache.displayList();
//
//	}
}
