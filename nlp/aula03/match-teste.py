print("Opções")
print("1) Cadastrar")
print("2) Alterar")
print("3) Pesquisar")
print("4) Excluir")

opcao = int(input("Escolha uma opcao"))

match( opcao ):
    case 1: print("Executar o cadastrar")
    case 2: print("Executar o alterar")
    case 3: print("Executar o pesquisar")
    case 4: print("Executar o excluir")
    case _: print("Opcao invalida")

# if opcao == 1:
#     print("Executar o cadastrar")
# elif opcao == 2:
#     print("Executar o alterar")
# elif opcao == 3:
#     print("Executar o pesquisar")
# elif opcao == 4:
#     print("Executar o excluir")
# else:
#     print("Opcao invalida")
