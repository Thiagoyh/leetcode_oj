#include <iostream>
#include <string>
#include <vector>
#include <unordered_set>

struct TrieNode
{
     int pass;
     int end;
     std::vector<TrieNode *> next;

     TrieNode(){
         pass = 0;
         end = 0;
         next = std::vector<TrieNode *>(26, NULL);
     }
     ~TrieNode(){
         for(int i = 0; i < 26; ++i){
             if(next[i] != NULL){
                 delete (next[i]);
             }
         }
     }
};

class Trie{

public:
    Trie(){
        root = new TrieNode;
    }

    void insert(std::string word){
        if(word.empty()){
            return;
        }
        TrieNode *node = root;
        node->pass++;
        int index = 0;
        for (size_t i = 0; i < word.size(); ++i){
            index = word[i] - 'a';
            if(node->next[index] == NULL){
                node->next[index] = new TrieNode();
            }
            node = node->next[index];
            node->pass++;
        }
        node->end++;
    }

    int search(std::string word){
        if(word.empty()){
            return root->end;
        }
        TrieNode *node = root;
        int index = 0;
        for(size_t i = 0; i < word.size(); ++i){
            index = word[i] - 'a';
            if(node->next[index] == NULL){
                return 0;
            }
            node = node->next[index];
        }
        return node->end;
    }

    int prefixNumber(std::string pre){
        if(pre.empty()){
            return 0;
        }
        TrieNode* node = root;
        int index = 0;
        for(size_t i = 0; i < pre.size(); ++i){
            index = pre[i] - 'a';
            if(node->next[index] == NULL){
                return 0;
            }
            node = node->next[index];
        }
        return node->end;
    }

    void deleteWord(std::string word){
        if(search(word) != 0){
            TrieNode *node = root;
            node->pass--;
            int index = 0;

            TrieNode* a = NULL;
            int deletIndex = -1;

            std::unordered_set<TrieNode*> mySet;

            for(size_t i = 0; i < word.size(); ++i){
                index = word[i] - 'a';
                if(--node->next[index]->pass == 0){
                    a = a == NULL ? node : a;
                    deletIndex = deletIndex == -1 ? index : deletIndex;

                    mySet.insert(node->next[index]);
                    return;
                }
                node = node->next[index];
            }
            node->end--;
            a->next[deletIndex] = NULL;
        }
    }

private:
    TrieNode* root;
};
