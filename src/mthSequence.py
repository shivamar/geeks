## Generate mth permutation sequence lexicographically
## 0,1,2 : 5th sequence is 201
def fact(n):    
    if(n==1): return 1
    if(n < 1): return 0
    return n * fact(n-1)

def combination(N, M):
    num_list = [0,1,2,3,4,5,6,7,8,9]
    num_list = num_list[0:N]
    ans=''
    i=1
    fac = fact(N-i)
    rem = M
    coeff = N-i
    while(i < N+1 ):
        for coeff in range(N-i,-1,-1):            
            if(fac * coeff >= rem and coeff > 0):
                continue
            else:
                print(num_list, coeff*fac, rem)
                digit = num_list.pop(coeff)
                ans += str(digit)               
                rem = rem - (coeff*fac)
                i=i+1 
                fac = fact(N-i)
                break
        

    
    print(ans)  
    
combination(3,2)