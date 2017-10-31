//Practest 3
//Sipho-sovuyo Manxoyi
//16 October 2017

public class Solution extends LinkedList{
   int i=0;
   public Solution(){
      super();
   }
   
   public int numLessThan(int testArg){
      while(true){
         if(head==null)
            break;
         if(head.getData()<testArg)
            i+=1;
         if(head.getNext()==null)
            break;
         head = head.getNext();
      }
      return i;
   }
}