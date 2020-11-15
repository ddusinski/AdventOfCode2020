package com.dusinski.chapter3;
import com.dusinski.*;

public class StackWithMin {

    Node topNode = null;


    public void push(int value){
        Node newNode = new Node(value);
        if (topNode==null){
            newNode.minValue=value;
        }else{
            if (topNode.minValue<value){
                newNode.minValue=topNode.minValue;
            }else {
                newNode.minValue=value;
            }
        }

        newNode.next=this.topNode;
        this.topNode=newNode;
    }

    public String toString(){
        return  Node.printList(this.topNode);
    }

    public int pop(){
        if (topNode==null){
            return 0;
        }
        int tempVal=topNode.data;
        topNode=topNode.next;
        return tempVal;
    }
    public int min(){
        return this.topNode.minValue;

    }

}
