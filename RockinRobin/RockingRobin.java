import java.util.*;

public class RockingRobin implements Iterator<Integer> {
	public static void main(String[] args) {
		List<Integer> list1 = new LinkedList(Arrays.asList(1,4));
		List<Integer> list2 = new LinkedList(Arrays.asList(2,5));
		List<Integer> list3 = new LinkedList(Arrays.asList(3,6,7,8));

		RockingRobin rr = new RockingRobin(Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator())); 

		while(rr.hasNext()) {
			System.out.println(rr.next());
		}
	}

	private Iterator<Iterator<Integer>> top = null;
	private Collection<Iterator<Integer>> collections;

	public RockingRobin(Collection<Iterator<Integer>> collections) {
		top = collections.iterator();
		this.collections = collections;
	}

	@Override
	public boolean hasNext() {
		return collections.stream().anyMatch(Iterator::hasNext);
	}

	@Override
	public Integer next() {
		if (!top.hasNext()) {
			top = collections.iterator();
		}

		while (top.hasNext()) {
			Iterator<Integer> iti = top.next();

			if (iti.hasNext()) {
				return iti.next();
			}
		}

		throw new java.util.NoSuchElementException();
	}
}