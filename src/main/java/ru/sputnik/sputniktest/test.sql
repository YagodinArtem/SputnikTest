select card_number, status, count(card_number) as cntCard, count(status) as cntStatus
from black_list
group by card_number, status
HAVING count(card_number) > 1
   and count(status) > 1;


DELETE
FROM black_list
WHERE card_number IN
      (SELECT card_number
       FROM black_list
       group by card_number
       HAVING count(card_number) > 1
          and count(status) > 1);