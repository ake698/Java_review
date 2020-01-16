package com.nowcoder.TreeHfm;

import java.util.*;

/**
 * 编码实现
 * 基于HuffmanTree 的编码解码实现
 */
public class TestHuffmanCode {

    public static void main(String[] args) {
        String msg = "can you can a can as a can canner can a can.";
        byte[] bytes = msg.getBytes();
        //进行Huffman编码
        byte[] b = huffmanZzip(bytes);
        byte[] newBytes = decode(huffCodes,b);
        System.out.println(new String(newBytes));

    }

    /**
     * 使用指定的Huffman 编码表进行解码
     * @param huffCodes
     * @param
     * @return
     */
    private static byte[] decode(Map<Byte, String> huffCodes, byte[] bytes) {
        StringBuilder sb= new StringBuilder();
        //把byte数组转为一个二进制的字符串
        for (int i=0;i<bytes.length;i++) {
            byte b = bytes[i];
            boolean flag=(i==bytes.length-1);
            sb.append(byteToBitStr(!flag,b));
        }
        System.out.println(sb.toString());
        //把字符串按照指定的Huffman编码进行解码
        //把Huffman的键值对进行调换
        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry< Byte,String> enter : huffCodes.entrySet()) {
            map.put(enter.getValue(),enter.getKey());
        }
        //创建一个集合用来存byte
        List<Byte>list = new ArrayList<>();
        //处理字符串
        for (int i = 0; i <sb.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            //截取出一个key
            while(flag){
                String s = sb.substring(i,i+count);
                b = map.get(s);
                if(b==null){
                    count++;
                }else{
                    flag = false;
                }
            }
            list.add(b);
            i+=count;
        }
        //把集合转为数组
        byte[]b = new byte[list.size()];
        for (int i = 0; i <b.length ; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    private static String byteToBitStr(boolean flag,byte b){
        int temp = b;
        if(flag){
            temp |= 256;
            String str = Integer.toBinaryString(temp);
            return str.substring(str.length()-8);
        }
//        String str = Integer.toBinaryString(temp);
        return Integer.toBinaryString(temp);
    }
    /**
     * 进行Huffman 压缩的方法
     * @param bytes
     * @return
     */
    private static byte[] huffmanZzip(byte[] bytes) {
        //统计每个byte出现的次数，并放入集合中
        List<Node2> nodes = getNodes(bytes);
        //创建一颗Huffman树
        Node2 tree = createHuffmanTree(nodes);
//        System.out.println(tree);
        //创建一个Huffman编码表
        Map<Byte,String> huffCodes = getCodes(tree);
//        System.out.println(huffCodes);
        //编码
        byte [] b = zip(bytes, huffCodes);
        return b;
    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        //把需要压缩的 byte数组处理成一个二进制的字符串
        for(byte b:bytes){
            sb.append(huffCodes.get(b));
        }
//        System.out.println(sb.toString());
        //定义长度
        int len;
        if(sb.length()%8==0){
            len = sb.length()/8;
        }else{
            len = sb.length()/8+1;
        }
        //用于存储压缩后的byte
        byte[] by = new byte[len];
        int index = 0;
        for (int i = 0; i <sb.length() ; i+=8) {
            String strByte;
            if(i+8>sb.length()){
                strByte = sb.substring(i);
            }else{
                strByte = sb.substring(i,i+8);
            }
//            System.out.println(strByte);
            Byte byt =(byte)Integer.parseInt(strByte,2);  //二进制转换
//            System.out.println(strByte+"==="+byt);
            by[index] = byt;
            index++;
        }
        return by;
    }

    /**
     * 创建Huffman 编码表
     * @param tree
     * @return
     */
    //用于临时存储路径
    static StringBuilder sb = new StringBuilder();
    //存储Huffman 编码
    static Map<Byte,String> huffCodes = new HashMap<>();
    private static Map<Byte,String> getCodes(Node2 tree) {
        if(tree==null){
            return null;
        }
        getCodes(tree.left,"0",sb);
        getCodes(tree.right,"1",sb);
        return huffCodes;
    }


    private static void getCodes(Node2 node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if(node.data==null){
            getCodes(node.left,"0",sb2);
            getCodes(node.right,"1",sb2);
        }else{
            huffCodes.put(node.data,sb2.toString());
        }
    }

    /**
     * 创建Huffman树的
     * @param nodes
     * @return
     */
    private static Node2 createHuffmanTree(List<Node2> nodes) {
        while (nodes.size()>1){
            //排序
            Collections.sort(nodes);
//            System.out.println(nodes);
            //取出俩个权值最低的二叉树
            Node2 left = nodes.get(nodes.size()-1);
            Node2 right = nodes.get(nodes.size()-2);

            //创建新的二叉树
            Node2 parent = new Node2(null,left.weight+right.weight);

            //把之前取出来的俩二叉树设置为新创建的二叉树的子树
            parent.left = left;
            parent.right = right;
            //删除
            nodes.remove(left);
            nodes.remove(right);
            //添加新创建的树
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 把byte数组转为Node集合
     * @param bytes
     * @return
     */
    private static List<Node2> getNodes(byte[] bytes) {
        List<Node2> nodes = new ArrayList<>();
        //统计每一个byte出现的次数

        //存储每一个byte出现的次数
        Map<Byte,Integer>counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if(count == null){
                counts.put(b,1);
            }else{
                counts.put(b,count+1);
            }
        }
//        System.out.println(counts);
        //把每一个键值对转为一个node对象
        for(Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new Node2(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }



}
