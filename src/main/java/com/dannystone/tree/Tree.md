# 数据结构-树
## 前言
理一理基于树模型的数据结构，不理就会因为细小的差异，而搞混。
## 树的种类
- Reverse Tree in Nature
![naturalTree](imgs/naturalTree.png)
- Binary Search Tree
![tree](imgs/binarySearchTree.png)
    - 缺点：O(logN) -> O(N)
    ![tree](imgs/binarySearchTree_disadvantage.png)
    - how to solve it ?
    Balanced BST
        - red-black tree
            - definition violation fix rules: 
                - black aunt rotate
                - red aunt color-flip
    
- B-Tree
    - Btree definition
    ![tree](imgs/B-tree.png)
    - B-tree-with-order 5
    ![tree](imgs/B-tree-with-order5.png)
    
