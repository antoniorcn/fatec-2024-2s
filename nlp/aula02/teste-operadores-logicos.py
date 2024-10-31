idade = int( input("Por favor digite uma idade valida para uma pessoa que ainda esteja viva ") )

# if idade > 0:
#     if idade < 200:
#         print("Idade valida")
#     else:
#         print("Dificilmente há uma pessoa viva com mais de 150 anos")
# else:
#     print("A idade deve ser positiva")


#        (E) ou (OU)
if idade > 0 and idade < 200:
    print("Idade valida")
else:
    print("A idade deve ser entre 0 e 200")


# Tabela Verdade operador AND
#    E1   |   E2   |   S
#   True  |  True  |  True
#   False |  True  |  False
#   True  |  False |  False
#   False |  False |  False


# Tabela Verdade operador OR
#    E1   |   E2   |   S
#   True  |  True  |  True
#   False |  True  |  True
#   True  |  False |  True
#   False |  False |  False


# Tabela Verdade operador XOR
#    E1   |   E2   |  S
#   True  |  True  |  False
#   False |  True  |  True
#   True  |  False |  True
#   False |  False |  False