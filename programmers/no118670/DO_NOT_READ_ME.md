## TIL...??
###### ~~비스무리한거임.~~
---

강의를 듣고...

    2차원 배열을 Deque로 표현?구현? 할 때... 안풀리던 수학문제를 간단한 발상으로 간단하게 푸는 짜릿함? 그런걸 오랜만에 받았다...
    - 문제를 보고 저런 발상을 하기까지 얼마나 많은 문제를 풀었을까... 더 노력하자...
    - 많은 문제 풀기 vs 소수의 문제 딥하게 보기

    이런 문제를 풀어야 kakao에 들어가는구나...

내 코드와 강사님이 코드와 비교

    강사님의 풀이 방식이 머리에 깊게 남아 다른 풀이는 생각하지 않고 그대로 풀었다.
    - 하지만 디테일하게 보면 조금씩은 달랐다.

    2차원 배열 순회
    - 나 : for(for())
    - 강사님 : for each(for())
    - for 보단 for each 가 더 빠른 연산을 한다고 배웠다.
    - 배열을 순회할 때는 거의 for문만 썼는데 for each를 쓸 수 있는지 한번 더 새각해봐야겠다.
    
    if-else 산
    - 최종 Deque를 2차원 배열에 넣을 때
    - 나는 for(for())안에서 if문으로 산을 만들었다.
    - 강사님이 코드에선 for문 하나로 전체를 처리할 수 있는 로직을 구현했다.
    - 어떤게 좋은 코드인가는 아직 모르지만... 
    - 아마 내꺼가 더 안좋을꺼야...

---

이번주차 강의로 Deque의 존재와 메서드, 활용법들을 공부했다... 
문제더 풀어보고 확실하게 내껄로 만들자... 유용하다... 

#### Deque

    FIFO(Queue) / LIFO(Stack) 의 특징을 모두 갖고 있는 자료구조이다.
    

#### Deque 메서드 정리

    .contains(Object)
    - Deque에 Object가 포함되어 있는지. T/F 반환
    - 조건식에 주로 활용될 듯
    - 시간복잡도
    -- Object가 앞쪽에 위치하면 더 빠르게 찾는다.
    >>> TEST때 가장 처음에 있을 때 1ms도 안걸림.
    -- 최악의 경우 : O(N) - 가장 마지막에 있을 때

    .addFirst/Last(Oject)
    - Deque의 머리/꼬리쪽에 Oject 추가
    - 시간복잡도 O(1)

    .pollFirst/Last
    - Deque의 머리/꼬리쪽에 Oject 제거
    - 시간복잡도 O(1)

    .pollFirst/Last
    - Deque의 머리/꼬리쪽에 Oject 조회
    - 제거하지 않고 조회만 함
    - 시간복잡도 O(1) 

    .remove(Object)
    - Deque의 앞부분부터 순회하다가 존재하면 Object를 제거
    - 최초 1회만 제거
    - 제거 성공 : T / 실패 : F 반환
    - 시간복잡도는 .contains와 유사하다.

    + removeLast(Frist)Occurrence 로 시작 방향을 정할 수 있다.
    + removeAll(collection)는 collection에 포함된 모든 요소를 제거한다.
    
    .isEmpty
    - Deque에 요소가 존재하는지 T/F 반환.
    - 조건식에 주로 활용할 듯

    ❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌
    ❌.forEach(Consumer) ❌
    - Deque를 순회, 삭제 ㄴㄴ
    - 람다로 간단한 코드를 작성할 때 활용 가능할 듯.
    - for 이나 while문 보다 빠르다고 들었다
    ❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌

#### forEach, 향상된 for, while(isEmpty){pollFirst()} TEST

    forEach
    - Deque를 처음부터 끝까지 순회한다.
    - 가장 시간이 오래걸렸다.
    - 하지만 이 경우는 요소를 제거하지 않고 순회를 해준다.
    
    향상된 for / while(){}
    - 이 두가지의 경우 비슷한 방식으로 동작하는 것 같다.
    - 시간도 비슷하게 걸렸다.
    - 둘다 반복문 종료 후에 isEmpty로 확인해보면 비어 있다.

###### ~~공부를 더 해봐야 알겠지만 forEach를 쓰는 일은 거의 없을 것 같다..~~



    
    