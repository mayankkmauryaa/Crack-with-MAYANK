class LFUCache {
    class Node {
        int key, val, freq;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DoublyLL {
        Node head, tail;
        int size;

        DoublyLL() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0)
                return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    private int cap, minFreq;
    private HashMap<Integer, DoublyLL> freqMap;
    private HashMap<Integer, Node> keyMap;

    public LFUCache(int capacity) {
        this.cap = capacity;
        freqMap = new HashMap<>();
        keyMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyMap.containsKey(key))
            return -1;
        Node node = keyMap.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cap == 0)
            return;
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            if (cap == keyMap.size()) {
                DoublyLL list = freqMap.get(minFreq);
                Node last = list.removeLast();
                keyMap.remove(last.key);
            }
            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);
            // freqMap.computeIfAbsent(1, k -> new DoubleLL()).add(newNode);
            if (!freqMap.containsKey(1))
                freqMap.put(1, new DoublyLL());
            freqMap.get(1).add(newNode);
            minFreq = 1;
        }
    }

    public void updateFreq(Node node) {
        int oldF = node.freq;
        DoublyLL oldL = freqMap.get(oldF);
        oldL.remove(node);
        if (oldF == minFreq && oldL.size == 0)
            minFreq++;
        node.freq++;
        // freqMap.computeIfAbsent(node.freq, k -> new DoublyLL()).add(node);
        if(!freqMap.containsKey(node.freq))
            freqMap.put(node.freq, new DoublyLL());
        freqMap.get(node.freq).add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */