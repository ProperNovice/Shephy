package utils;

import java.util.Iterator;

public class ArrayList<T> implements Iterable<T> {

	private java.util.ArrayList<T> list = new java.util.ArrayList<>();

	public ArrayList() {

	}

	public ArrayList(ArrayList<T> arrayList) {
		this.list.addAll(arrayList.getList());
	}

	public void add(int index, T element) {
		this.list.add(index, element);
	}

	public boolean add(T e) {
		return this.list.add(e);
	}

	public boolean addAll(ArrayList<T> list) {

		for (T t : list)
			this.list.add(t);

		return true;
	}

	public void clear() {
		this.list.clear();
	}

	public boolean contains(Object o) {
		return this.list.contains(o);
	}

	public T get(int index) {
		return this.list.get(index);
	}

	public java.util.ArrayList<T> getList() {
		return this.list;
	}

	public int indexOf(Object o) {
		return this.list.indexOf(o);
	}

	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	public T remove(int index) {
		return this.list.remove(index);
	}

	public boolean remove(Object o) {
		return this.list.remove(o);
	}

	public void shuffle() {

		java.util.ArrayList<T> listOriginal = new java.util.ArrayList<>(
				this.list);
		this.list.clear();

		while (!listOriginal.isEmpty())
			this.list.add(listOriginal.remove(Random.getRandomNumber(0,
					listOriginal.size() - 1)));

	}

	public T getFirst() {
		return this.list.get(0);
	}

	public T getFirstAndRemove() {

		T first = this.list.remove(0);
		return first;

	}

	public T getRandomAndRemove() {

		int randomIndex = Random.getRandomNumber(0, this.list.size() - 1);
		T randomObject = this.list.remove(randomIndex);
		return randomObject;

	}

	public int size() {
		return this.list.size();
	}

	@Override
	public Iterator<T> iterator() {
		return this.list.iterator();
	}

}
