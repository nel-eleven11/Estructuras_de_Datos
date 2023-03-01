

def fibbonacci(ciclo , elem, n1, n2):
    n = ciclo + 1
    n1 = n1
    n2 = n2

    temp = n2
    n2 = n1 + n2
    n1 = temp

    print(f"Ciclo {ciclo}: {n2}")

    if n <= elem:
        fibbonacci(n, elem, n1, n2)

fibbonacci(0, 15, 0, 1)
