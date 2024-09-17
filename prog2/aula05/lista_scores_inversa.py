hi_scores = [9000, 7000, 6435, 5723, 4200, 
             3199, 2955, 1323, 1243, 1111]

hi_score_names = ["JOA", "JOA", "JOA", "MIK", "MIK",
                  "STV", "BOB", "JOE", "BOB", "JOE"]

quantidade_elementos = len(hi_scores)
indice = quantidade_elementos - 1
while indice >= 0:
    print(hi_scores[indice], hi_score_names[indice])
    indice = indice - 1