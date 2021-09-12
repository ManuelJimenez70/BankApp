package models;

public class MyList {
	private Node<Transaction> first;

	public MyList(Node<Transaction> first) {
		this.first = first;
	}

	public void print() {
		System.out.println("------------------------");
		Node<Transaction> actual = first;
		while (actual != null) {
			System.out.println(actual);
			actual = actual.getNext();
		}
	}

	public int getActualbalance() {
		Node<Transaction> actual = first;
		int balance = 0;
		while (actual != null) {
			Transaction t = actual.getTransaction();
			if (t.getType().equals(TransactionType.CONSIGN)) {
				balance += t.getValue();
			} else {
				balance -= t.getValue();
			}
			actual = actual.getNext();
		}
		return balance;
	}

	public void addElement(Node<Transaction> node) throws OutOfBalanceException {
		Node<Transaction> actual = first;
		while (actual.getNext() != null) {
			actual = actual.getNext();
		}
		if (node.getTransaction().getType().equals(TransactionType.WITHDRAWALS)) {
			if (getActualbalance() - node.getTransaction().getValue() >= 0) {
				actual.setNext(node);
			}else {
				throw new OutOfBalanceException();
			}
		}else {
			actual.setNext(node);
		}
	}

	public void addAtStart(Node<Transaction> node) throws OutOfBalanceException {
		if (getActualbalance() - node.getTransaction().getValue() >= 0) {
			node.setNext(first);
			first = node;
		} else {
		}
	}

	public int getSize() {
		int count = 0;
		Node<Transaction> actual = first;
		while (actual != null) {
			actual = actual.getNext();
			count++;
		}
		return count;
	}

	public Node<Transaction> getFirst() {
		return first;
	}

	public static void main(String[] args) {
		Node<Transaction> t1 = new Node<>(new Transaction(TransactionType.CONSIGN, 1000));
		Node<Transaction> t2 = new Node<>(new Transaction(TransactionType.CONSIGN, 3000));
		Node<Transaction> t3 = new Node<>(new Transaction(TransactionType.WITHDRAWALS, 4000));
		Node<Transaction> t4 = new Node<>(new Transaction(TransactionType.CONSIGN, 1000));

		MyList list = new MyList(t1);
		try {

			list.addElement(t2);

			list.addElement(t3);

			list.addElement(t4);
			System.out.println(list.getActualbalance());
			System.out.println(System.getProperty("user.name"));
		} catch (OutOfBalanceException e) {
			e.printStackTrace();
		}
	}
}
