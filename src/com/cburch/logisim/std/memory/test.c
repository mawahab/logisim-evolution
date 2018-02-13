a= …
for(i=0;i<N;i++){
	for(j=0;j<M;j++){
		X[i,j]=f(X[j-1,j],X[i,j-1]);
	}
}
Y=X[…]


	a= …
	for(ii=2;ii<N;ii+=2){
		// Wavefront
T0:		tile(ii,0)
T1:		tile(ii-1,1)
T2:		tile(ii-2, 2)
	}
	Y=X[…]


void tile(int ii, int jj) {
	for(i=ii;i<min(N,ii+2);i++){
		for(j=jj;j<min(M,jj+2);j++){
			X[i,j]=f(X[j-1,j],X[i,j-1]);
		}
	}
}

void tile(int ii, int jj) {
R:	for(i=ii-1;i<min(N,ii+2);i++){
		memcpy(priv[i-ii-1][jj],X[i][j],3)
	}
E:	for(i=ii;i<min(N,ii+2);i++){
		for(j=jj;j<min(M,jj+2);j++){
			X[i,j]=f(X[j-1,j],X[i,j-1]);
		}
	}
W:	for(i=ii;i<min(N,ii+2);i++){
		memcpy(X[i][jj],priv[i-ii][1],2)
	}
}


for(i=1;i<N-1;i++)
   for(j=0;j<M;j++)
S0:   tmp[i][j]=f(in[i][j],in[i-1][j],in[i+1][j]);

for(i=1;i<N-1;i++)
   for(j=1;j<M-1;j++)
S1:   out[i][j]=f(tmp[i][j],tmp[i][j-1],tmp[i][j+1]);

for(i=1;i<N-1;i++)
  for(j=0;j<M;j++)
S0:   tmp[i][j]=f(in[i][j],in[i-1][j],in[i+1][j]);
S1:   out[i][j]=f(tmp[i][j],tmp[i][j-1],tmp[i][j+1]);


for(i=1;i<N-1;i++) {
  for(j=0;j<2;j++)
S0:   tmp[i][j]=f(in[i][j],in[i-1][j],in[i+1][j]);
  for(j=2;j<M-1;j++) {
S0:   tmp[i][j]=f(in[i][j],in[i-1][j],in[i+1][j]);
S1:   out[i][j]=f(tmp[i][j-2],tmp[i][j-1],tmp[i][j]);
  }
}


   for(i=1;i<N-1;i++) {
  for(j=0;j<2;j++)
S0:   tmp[j%3]=f(in[i][j],in[i-1][j],in[i+1][j]);
  for(j=2;j<M-1;j++) {
S0:   tmp[j%3]=f(in[i][j],in[i-1][j],in[i+1][j]);
S1:   out[i][j]=f(tmp[(j-1)%3],tmp[(j-2)%3],tmp[j%3]);
  }
}

