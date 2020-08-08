public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        Deque q = wordToDeque(word);

        return helper(q);
    }

    private boolean helper(Deque<Character> q) {
        if (q.size() <= 1) {
            return true;
        } else if (q.removeLast() == q.removeFirst()) {
            q.removeFirst();
            q.removeLast();
            return helper(q);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
       Deque q = wordToDeque(word);

       return helper(q, cc);
    }

    private boolean helper(Deque<Character> q, CharacterComparator cc) {
        if (q.size() <= 1) {
            return true;
        } else if (cc.equalChars(q.removeFirst(), q.removeLast())) {
            q.removeFirst();
            q.removeLast();
            return helper(q,cc);
        } else {
            return false;
        }
    }
}
