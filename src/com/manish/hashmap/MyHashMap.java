package com.manish.hashmap;

import java.util.Arrays;

public class MyHashMap {
    public static void main(String args[]){
        HashMap hashMap = new HashMap(2);
        hashMap.put("Jan", "January");
        hashMap.put("Feb", "Febuary1");
        hashMap.put("Feb", "February2");//
        hashMap.put("Mar", "March");
        hashMap.put("Apr", "April");
        hashMap.delete("Jan");//
        System.out.println(hashMap);
//        hashMap.delete("Feb");
        System.out.println("value of jan "+hashMap.get("Jan"));
        System.out.println("value of feb "+hashMap.get("Feb"));
//        System.out.println(hashMap.get("Feb"));
//        System.out.println(hashMap.get("Mar"));
//        System.out.println(hashMap.get("Apr"));

    }
}

class HashMap{


   static class Entry{
        String key;
        String value;
        Entry next=null;
        Entry(String key,String value){
            this.key=key;
            this.value=value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
    private Entry entry;
    int BUCKET_SIZE=4;
    Entry []bucket;

    HashMap(int size){
         this.BUCKET_SIZE=size;
         bucket = new Entry[size];
    }
    public String get(String key){
        int hash= key.length()%BUCKET_SIZE;
        Entry entry = bucket[hash];
        if(entry==null){
            return "0";
        }else{
            while(entry!=null){
                if(entry.key.equalsIgnoreCase(key)){
                    return entry.value;
                }
                entry = entry.next;
            }
        }
    return "0";
    }

    public void put(String key,String value){
        boolean found= false;
        if(key!=null){
            int hash= key.length()%BUCKET_SIZE;
            Entry entry = bucket[hash];
            if(entry==null){
                entry = new Entry(key,value);
                bucket[hash]=entry;//
            }else{
                Entry cur = entry;
                while (cur!=null){
                        if(cur.key.equalsIgnoreCase(key)){
                            cur.value= value;
                            return;
                        }
                        cur = cur.next;
                }
                    cur= new Entry(key,value);
            }
        }
    }
    public void delete(String key){
        if(key!=null){
            int hash = key.length()%BUCKET_SIZE;
            Entry entry= bucket[hash];
            if(bucket==null){
                System.out.println("No such key");
                return;
            }
            Entry prev = entry;
            Entry cur = entry;
            while(cur!=null){
                if(cur.next==null){

                }
                if(cur.key.equalsIgnoreCase(key)){
                    prev.next= cur.next;
                    cur = null;
                    return;
                }else{
                    ////
                    prev = cur;
                    cur = cur.next;
                }
            }
        }

    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "bucket=" + Arrays.toString(bucket) +
                '}';
    }
}
