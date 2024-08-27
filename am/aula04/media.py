disciplines = ["Matemática", "Ciências", 
"História", "Inglês", "Arte", "Educação Física"]

grades = [
    [8.5, 7.2, 9.0, 6.8],
    [6.0, 7.5, 8.2, 9.5],
    [7.8, 8.0, 7.2, 6.5],
    [9.2, 8.5, 7.0, 8.8],
    [8.0, 7.5, 8.5, 9.0],
    [9.0, 9.2, 8.8, 9.5]
]

for indice in range(6):
    soma = 0
    lista_notas = grades[indice]
    for numero in lista_notas:
        soma += numero
    qtd = len(lista_notas)
    media = soma / qtd
    print("Ficou com media ", media , 
            " em ", disciplines[indice])
