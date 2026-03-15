Wrote two simple applications ( one which can operate in two modes) which com
municates with each other by writing and reading data from a shared file mapped into
memory.
One of the applications saves some data– e.g., two integer values. The other appli
cation retrieves the data and perform some operation — e.g., adds the values read
and prints out the result to the console.
Reader and writer able to run in a loop („sleeping” for some time to make the program
slower). Writer repeatedly attempts to write data to the shared file and stops writing
after a prescribed number of successful writes (this number is not known the reader).
On the other hand, the reader should await for the data produced by the writer until
it makes sense, i.e., when the writer is still working.
Writer must not overwrite data put previously by itself into the file until the reader
fetches it from the file. Analogously, the reader must not re-read data which has
already been read. In other words reader should read particular data (message) once
only.
