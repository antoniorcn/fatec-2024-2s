palavras = ["O", "ano", "é", "curto", "para", "aprender",
            "a", "programar"]

if "Fatec" not in palavras:
    print("Não está contido na lista de palavras")
else:
    print("Está contido na lista de palavras")

genero = True # Masculino    False = Feminino
# nome = "Darci Ribeiro: "
# if genero == True:
#     print(nome + "Masculino")  
# else:
#     print(nome + "Feminino")  

# nome = "Darci Ribeiro"
texto = "Darci Ribeiro: " + ("Masculino" if genero else "Feminino")
print(texto)



aprovado = True
# if aprovado: 
#     print("X foi aprovado")
# else:
#     print("X foi reprovado")
texto = "X foi " + ("aprovado" if aprovado else "reprovado")
print(texto)