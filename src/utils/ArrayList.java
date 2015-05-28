package utils;

import java.util.Iterator;

public class ArrayList<T> implements Iterable<T> {

	private java.util.ArrayList<T> list = new java.util.ArrayList<>();

	public ArrayList() {

	}

	public ArrayList(ArrayList<T> arrayList) {

		for (T t : arrayList)
			this.list.add(t);

	}

	public ArrayList(T[] list) {
		addAll(list);
	}

	private ArrayList(java.util.ArrayList<T> list) {
		this.list = list;
	}

	public void add(int index, T element) {
		this.list.add(index, element);
	}

	public void addFirst(T element) {
		add(0, element);
	}

	public boolean add(T e) {
		return this.list.add(e);
	}

	public boolean addAll(ArrayList<T> list) {

		for (T t : list)
			this.list.add(t);

		return true;
	}

	public boolean addAll(T[] list) {

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

	public T removeFirst() {
		return this.list.remove(0);
	}

	public T removeLast() {
		return this.list.remove(this.list.size() - 1);
	}

	public T getRandom() {
		return this.list.get(Random.getRandomNumber(0, this.list.size() - 1));
	}

	public T removeRandom() {
		int randomIndex = Random.getRandomNumber(0, this.list.size() - 1);
		return this.list.remove(randomIndex);
	}

	public int size() {
		return this.list.size();
	}

	@Override
	public Iterator<T> iterator() {
		return this.list.iterator();
	}

	public void printList() {

		System.out.println("/*");

		for (T t : this.list)
			System.out.println(t);

		System.out.println("*/");
		System.out.println();

	}

	public ArrayList<T> clone() {

		java.util.ArrayList<T> arrayList = new java.util.ArrayList<>(this.list);
		return new ArrayList<T>(arrayList);
	}

}
