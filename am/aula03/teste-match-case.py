print("Menu de Opcoes")
print("1 - X Burguer")
print("2 - X Salada")
print("3 - Batatas")
print("4 - Refrigerante")
print("5 - Encerrar pedido")

opcao = int(input("Escolha sua opção: "))

match(opcao):
    case 1: print("Adicionando X Burguer ao pedido")
    case 2: print("Adicionando X Salada ao pedido")
    case 3: print("Adicionando Batatas ao pedido")
    case 4: print("Adicionando Refrigenrante ao pedido")
    case 5: print("Pedido encerrado faça o pagamento")
    case _: print("Opção inválida")
