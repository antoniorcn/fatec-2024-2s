"""
Faça um programa para desenhar um retangulo
na tela utilizando for com 5 linhas e 10 colunas
conforme abaixo:
"""
# linhas = 20
# colunas = 15
# for i in range(0, linhas):
#     print("##########")

linhas = 10
colunas = 30
for lin in range(linhas):
    for col in range(colunas):
        print("#", end="")
    print()