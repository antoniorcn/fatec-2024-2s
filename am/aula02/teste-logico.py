print("Digite uma idade valida " + 
      "para uma pessoa ainda viva: ")
idade = int(input())

if idade > 0 and idade < 150:
    print("Idade valida")
else:
    print("A idade deve estar entre 1 e 149 anos")

'''
    Operador AND
   E1    |    E2     |  S
   True  |    True   |  True
   True  |    False  |  False
   False |    True   |  False
   False |    False  |  False


       Operador OR
   E1    |    E2     |  S
   True  |    True   |  True
   True  |    False  |  True
   False |    True   |  True
   False |    False  |  False


       Operador XOR
   E1    |    E2     |  S
   True  |    True   |  False
   True  |    False  |  True
   False |    True   |  True
   False |    False  |  False

   

'''


# if idade < 0:
#     print("Idade deve ser positiva")
# else:
#     if idade > 150:
#         print("Por favor digite uma idade valida")
#     else:
#         print("Idade valida")

