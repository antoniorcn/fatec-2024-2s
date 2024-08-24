class Aluno:
    nome = ""
    ra = ""

a1 = Aluno()
a2 = Aluno()
a1.nome = "Joao"
a1.ra = "00001"

a2.nome = "Maria"
a2.ra = "00002"

a3 = a1
a3.nome = "Alberto"
print(a3.nome)
mesmo_objeto = a1 is a3
print(f"São o mesmo objeto: {mesmo_objeto}")