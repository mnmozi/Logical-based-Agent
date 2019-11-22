grid(5,5).
thanos(3,4).
ironman(1,2,[stone(1,1),stone(2,1),stone(2,2),stone(3,3)],s0).
ironman(Y, X, NotPicked, result(A, S)):-
    ( ironman(YO,X, NotPicked, S), A = up, Y is YO - 1 , Y >= 0 );
    ( ironman(YO,X, NotPicked, S), A = down, Y is YO + 1, grid(GY,_), Y =< (GY - 1) );
    ( ironman(Y,XO, NotPicked, S), A = right, X is XO +1, grid(_,GX), X =< (GX - 1) );
    ( ironman(Y,XO, NotPicked, S), A = left, X is XO - 1, X >= 0 );
    ( ironman(Y, X, OldNotPicked, S),member(stone(Y,X), OldNotPicked), del(stone(Y,X), OldNotPicked, NotPicked),  A = collect).

snapped(result(snap, S)):-snap(S,1).

snap(S,L):-
    (call_with_depth_limit(( ironman(Y, X, H, S), H =[],thanos(Y,X) ),L,R),\+R=depth_limit_exceeded);
    ((L1 is L + 1),snap(S,L1)).

del(Y, [Y], []).
del(X,[X|LIST1], LIST1).
del(X,[Y|LIST], [Y|LIST1]):- del(X,LIST,LIST1).