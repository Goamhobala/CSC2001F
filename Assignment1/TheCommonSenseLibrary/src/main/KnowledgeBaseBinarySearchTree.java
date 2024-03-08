public class KnowledgeBaseBinarySearchTree extends KnowledgeBase{
    class BinaryTreeNode{
        Entry data;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(Entry data, BinaryTreeNode left, BinaryTreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    
        BinaryTreeNode(Entry data){
            this(data, null, null);
        }
    
    }

    private BinaryTreeNode root;
    
    public KnowledgeBaseBinarySearchTree(BinaryTreeNode root){
        this.root = root;
    }

    public KnowledgeBaseBinarySearchTree(){
        this(null);
    }

    @Override
    public Entry searchEntry(String term){
        return search(new Entry(term)).data;
    }

    public BinaryTreeNode search(Entry data){
        return search(data, root);
    }
    
    public BinaryTreeNode search(Entry data, BinaryTreeNode node){
        if (node == null){
            return null;
        }
        int compare = data.compareTo(node.data);
        if (compare == 0){
            return node;
        }
        else if (compare < 0){
            return search(data, node.left);
        }

        else{
            return search(data, node.right);
        }
        
    }

    @Override
    public void insert(Entry data){
        if (this.root == null){
            this.root = new BinaryTreeNode(data);
        }
        else insert(data, this.root);
    }

    public void insert(Entry data, BinaryTreeNode node){
        int compare = data.compareTo(node.data);
        if (compare < 0){
            if (node.left == null){
                node.left = new BinaryTreeNode(data);
            }
            else{
                insert(data, node.left);
            }
        }
        else{
            if (node.right == null){
                node.right = new BinaryTreeNode(data);
            }
            else{
                insert(data, node.right);
            }
        }
    }
} 

//     public BinaryTreeNode delete(T data){
//         this.root = delete(data, this.root);
//     }

//   public BinaryTreeNode delete(T data, BinaryTreeNode node){
//         if (node == null){
//             return null;
//         }
        
//         int compare = data.compareTo(node.data);
//         if (compare < 0){
//             node.left = delete(data, node.left);
//         }
//         else if (compare > 0){
//             node.right = delete(data, node.right);
//         }

//         else{
//             if (node.left != null){
//                 if (node.right != null){
//                     BinaryTreeNode min = findMin(node.right);
//                     removeMin(node.right);
//                     min.left = node.left;
//                     node = min;
//                     // Or alternatively
//                     // node.data = findMin(node.right);
//                     // node.right = removeMin(node.right);
                    
//                 }
//                 else{
//                     node = node.left;
//                 }
//             }
//             else{
//                 if (node.right != null){
//                     node = node.right;
//                 }
//                 else{
//                     node = null;
//                 }
//             }
//         }
//         return node;
//     }
// }

