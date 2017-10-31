public class RingBuffer{
  public Object[] elements = null;

  private int capacity = 0;
  private int writePos = 0;
  private int available = 0;

  public RingBuffer(int capacity){
    this.capacity = capacity;
    this.elements = new Object[capacity];
  }

  public void reset(){
    this.writePos = 0;
    this.available = 0;
  }

  public int capacity(){return this.capacity;}
  public int available(){return this.available;}

  public boolean put(Object element){
    if (available<capacity) {
      if (writePos>=capacity) {
        writePos = 0;
      }
      elements[writePos] = element;
      writePos++;
      available++;
      return true;
    }
    return false;
  }

  public Object take(){
    if (available == 0) {
      return null;
    }
    int nextSlot = writePos - available;
    if (nextSlot < 0) {
      nextSlot += capacity;
    }
    Object nextObj = elements[nextSlot];
    available--;
    return nextObj;
  }
}


public boolean validate() {
        boolean result = true;
        Stack<Character> stack = new Stack<Character>();
        char current, previous;
        for(int i = 0; i < this.brackets.length(); i++) {
            current = this.brackets.charAt(i);
            if(current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if(current == ')' || current == ']' || current == '}') {
                if(stack.isEmpty()) {
                    result = false;
                } else {
                    previous = stack.peek();
                    if((current == ')' && previous == '(') || (current == ']' && previous == '[') || (current == '}' && previous == '{')) {
                        stack.pop();
                    } else {
                        result = false;
                    }
                }
            }
        }
        if(!stack.isEmpty()) {
            result = false;
        }
        return result;
    }
