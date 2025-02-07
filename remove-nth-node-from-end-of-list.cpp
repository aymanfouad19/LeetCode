#include <iostream>
using namespace std;
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
         ListNode* temp;
    int i = 0;
    temp = head;
    if (n < 0) {
        cout << "Invalid Index";
    }
    while (temp != nullptr) {
        i++;
        temp = temp->next;
    }
    if (n > i) {
        cout << "Invalid Index" << endl;
        return head;
    }
    if(n==i){
        delete temp;
    }
    temp = head;
    for (int j = 0; j < i - n; j++) {
        temp = temp->next;
    }
    if (temp == head) {
        head = temp->next;
    } else {
        ListNode* prev = head;
        while (prev->next != temp) {
            prev = prev->next;
        }
        prev->next = temp->next;
    }
    delete temp;
    return head;
    }
};
